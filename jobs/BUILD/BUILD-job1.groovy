job {
    name 'BUILD-job1'
    scm {
        git('https://github.com/Azulinho/bristol-devops-jenkins-jobs.git')
        { node ->
            node / authorOrCommitter << 'true'
            node / gitConfigName << 'Azul'
            node / gitConfigEmail << 'notme@gmail.org'
        }
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