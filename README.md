# ReportPortalDemo
<h1>TestNG + Selenium + Docker + Report Portal + MacOs</h1>
<ol>
<li>Install docker 

```
https://docs.docker.com/engine/install/
```
</li><li>
Download the latest ReportPortal Docker compose file 

```
curl -LO https://raw.githubusercontent.com/reportportal/reportportal/master/docker-compose.yml
```
</li><li>
Report portal recommends you use allocate at least 3 GB of ram and this could be set up via the Docker desktop console.

```
Docker Settings > Resources > Edit the memory usage
```
</li><li>
Install Elasticsearch image

```
docker pull docker.elastic.co/elasticsearch/elasticsearch:7.10.2
```

</li><li>
Starting a single node cluster with docker 

```
docker run -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:7.10.2
```

</li><li>
Set vm.max_map_count to at least 262144

```
docker-machine ssh
sudo sysctl -w vm.max_map_count=262144
```

If this does't work go to 

```
cd /Library/Containers/com.docker.docker/Data/vms/0
mkdir tty
sysctl -w vm.max_map_count=262144
```

</li><li>
Give permission to elastic search 

```
mkdir -p Data/elasticsearch
chmod 777 Data/elasticsearch
chgrp 1000 data/elasticsearch -> Don't worry if this gives error
``` 

</li><li>
Start the report portal 

```
docker-compose -p reportportal up -d --force-recreate
```

</li><li>
Open in browser

```
http://localhost:8080/ui/#login
```

Login using : `superadmin\erebus`

</li><li>
  Create a blank project in report portal

</li><li>Clone the github project. 

</li><li>Edit the reportportal.properties with the profile information of the project you created.

</li><li>Run runner.xml file.
</ol>
<h2>References</h2>
<ul>
  <li>Listeners that can be used in project -> <b>https://github.com/reportportal/agent-java-testNG#using-listeners-annotation</b>
    </li><li>
Report portal documentation -> <b>https://reportportal.io/docs/Deploy-with-Docker</b>
  </li><li>
Elastic Search docker documentation -> <b>https://www.elastic.co/guide/en/elasticsearch/reference/7.10/docker.html#_set_vm_max_map_count_to_at_least_262144</b>
  </li>


<h4>Dependencies used :</h4>

```<dependency>
<groupId>com.epam.reportportal</groupId>
<artifactId>agent-java-testng</artifactId>
<version>5.1.0-RC-4</version>
</dependency>

<dependency>
  <groupId>com.epam.reportportal</groupId>
  <artifactId>logger-java-log4j</artifactId>
  <version>5.1.0-RC-1</version>
</dependency>```
