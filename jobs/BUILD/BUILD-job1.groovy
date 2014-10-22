job {
    name 'BUILD-job1'
    scm {
        git('https://github.com/facebook/AsyncDisplayKit.git')
    }
    triggers {
        scm('*/15 * * * *')
    }
    steps {
        downstreamParameterized {
            trigger('DEPLOY-job1') {
                currentBuild()
            }
        }
    }
}