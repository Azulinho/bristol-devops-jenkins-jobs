job {
    name 'DEPLOY-job2'
    steps {
        downstreamParameterized {
            trigger('DEPLOY-job3') {
                currentBuild()
            }
        }
    }
}