job {
    name 'DEPLOY-job1'
    parameters {
        stringParam("PARAM1")
        stringParam("PARAM2")
    }
    deliveryPipelineConfiguration("Stage 1", "Task 1")

    configure {
        (it / 'blockBuildWhenUpstreamBuilding').setValue('true')
        (it / 'blockBuildWhenDownstreamBuilding').setValue('true')
    }

    configure {
        (it / 'properties' / 'hudson.plugins.throttleconcurrents.ThrottleJobProperty' / 'maxConcurrentPerNode').setValue('0')
        (it / 'properties' / 'hudson.plugins.throttleconcurrents.ThrottleJobProperty' / 'maxConcurrentTotal').setValue('1')
        (it / 'properties' / 'hudson.plugins.throttleconcurrents.ThrottleJobProperty' / 'throttleEnabled').setValue(true)
        (it / 'properties' / 'hudson.plugins.throttleconcurrents.ThrottleJobProperty' / 'throttleOption').setValue('category')
        (it / 'properties' / 'hudson.plugins.throttleconcurrents.ThrottleJobProperty' / 'categories').setValue('Stage 1')
    }

    steps {
        shell("echo DEPLOY 1")
    }
    publishers {
        downstreamParameterized {
            trigger('DEPLOY-job2') {
                currentBuild()
            }
        }

    }
}