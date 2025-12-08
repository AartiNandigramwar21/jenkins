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
             sh '''/opt/maven/bin/mvn sonar:sonar \\
              -Dsonar.projectKey=projectapp \\
              -Dsonar.host.url=http://13.204.43.80:9000 \\
              -Dsonar.login=87f3be17363654c6aa54f1cfa631bf17c9436ebf'''
             }
        }
        stage('deploy') 
            steps {
                echo "deploy sucess"
            }
        }
     }
