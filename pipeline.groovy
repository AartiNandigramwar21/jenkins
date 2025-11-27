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
                withSonarQubeEnv(installationName:'sonar',credentialsId: 'sonar-token') {
                        sh '/opt/maven/bin/mvn sonar:sonar'
                   }   
                }
        }
        stage('deploy') {
            steps {
                echo "deploy sucess"
            }
        }
    }
}