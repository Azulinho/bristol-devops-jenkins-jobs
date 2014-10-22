job {
    name 'DEPLOY-job1'
    steps {
        downstreamParameterized {
            trigger('DEPLOY-job2') {
                currentBuild()
            }
        }
    }
}