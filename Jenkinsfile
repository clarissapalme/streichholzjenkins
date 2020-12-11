pipeline {
    agent any

    stages {
        stage('Test') {
            steps {
                echo 'Testing.., Hier ist Branch main'
            }
        }
    }
   post {
       always {
          mail to:  'clarissa.itschert@th-brandenburg.de',
	     subject: "Schreiben von Jenkins, main",
             body:  "Emailtext, automatisch von Jenkins gesendet."
       }
   }
}
