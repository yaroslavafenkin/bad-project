node {
    stage ("Build") {
        checkout scm
        bat("mvn verify")
    }

    stage ("Record issues") {
        recordIssues([tool: spotBugs(pattern: '**/target/spotbugsXml.xml'),
            sourceCodeEncoding: 'UTF-8',
            skipBlames: true,
            trendChartType: 'TOOLS_ONLY',
            qualityGates: [[threshold: 1, type: 'NEW', unstable: true]]])
        recordIssues([tool: checkStyle(pattern: '**/target/checkstyle-result.xml'),
            sourceCodeEncoding: 'UTF-8',
            skipBlames: true,
            trendChartType: 'TOOLS_ONLY',
            qualityGates: [[threshold: 1, type: 'TOTAL', unstable: true]]])
    }
}