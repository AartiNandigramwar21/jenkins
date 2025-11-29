pipeline {
    agent {label 'slave'}
    stages {
        stage('pull-stage') {
            steps {
                // git branch: 'main', url: 'https://github.com/Anilbamnote/student-ui-app.git'
               git branch: 'main', url: 'https://github.com/Rupen04/artifact_pom.git'
            }
        }
        stage('Build') {
            steps {
                sh '/opt/maven/bin/mvn clean package'
            }
        }
        stage('test') {
            steps {
                  
               sh ''' /opt/maven/bin/mvn sonar:sonar \\
                  -Dsonar.projectKey=projectapp \\
                  -Dsonar.host.url="http://3.110.120.203:9000/"
                  -Dsonar.login=fcc4363236ee001b774c752bcb4bbd0a05e8a79b'''
             }
        }
        stage('deploy') {
            steps {
                echo "deploy sucess"
            }
        }
    }
}