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
        (it / 'properties' / 'hudson.plugins.throttleconcurrents.ThrottleJobProperty').setValue('maxConcurrentPerNode:0')
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