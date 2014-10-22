job {
    name 'DEPLOY-job3'
    steps {
        downstreamParameterized {
            trigger('DEPLOY-job4') {
                currentBuild()
            }
        }
    }
}