job {
    name 'DEPLOY-job2'
    steps {
        shell("echo lixo")
    }
    publishers {
        downstreamParameterized {
            trigger('DEPLOY-job3') {
                currentBuild()
            }
        }
    }
}