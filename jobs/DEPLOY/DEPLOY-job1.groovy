job {
    name 'DEPLOY-job1'
    parameters {
        stringParam("PARAM1")
        stringParam("PARAM1")
    }
    deliveryPipelineConfiguration("Stage 1", "Task 1")

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