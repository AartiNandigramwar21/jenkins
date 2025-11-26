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
                sh '''/opt/maven/bin/mvn sonar:sonar \\-Dsonar.projectKey=projectapp \\-Dsonar.host.url="http://13.201.69.204:9000" \\-Dsonar.login=8fa7659bdc79c28b6031058cc56f42f8ec08c45c'''
                 withSonarQubeEnv(credentialsId: 'sonar-cred') { // some block  
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