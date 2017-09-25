freeStyleJob('example') {
    logRotator(-1, 10)
    jdk('JAVA_HOME')
    scm {
        github('https://github.com/devopsdocs/client-demo-project.git', 'master')
    }
    triggers {
        scm("H/15 * * * *")
    }
    steps {
        maven('clean install')
    }
    publishers {
        archiveArtifacts('target/*.war')
    }
}