def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t arunr039/groovy:1.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push arunr039/groovy:1.0'
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 
def readCsv(){
 def mapList = []
 def headers = []
new File("SynthiaProd_data.csv").readLines().eachWithIndex { row, rowIndex ->
    if (rowIndex == 0) { headers = row.split(',') }
    else {
        def tmpMap = [:]
        def cells = row.split(',').eachWithIndex { cell, cellIndex ->
          tmpMap[headers[cellIndex]] = cell
        }
        mapList.add(tmpMap)
    }
}
}

return this
