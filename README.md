# ReportPortalDemo
<h1>TestNG + Selenium + Docker + Report Portal + MacOs</h1>
1. Install docker 

```https://docs.docker.com/engine/install/```

2. Download the latest ReportPortal Docker compose file 

```curl -LO https://raw.githubusercontent.com/reportportal/reportportal/master/docker-compose.yml```

3. Report portal recommends you use allocate at least 3 GB of ram and this could be set up via the Docker desktop console.

```Docker Settings > Resources > Edit the memory usage```

4.Install Elasticsearch image

```docker pull docker.elastic.co/elasticsearch/elasticsearch:7.10.2```

5. Starting a single node cluster with docker 

```docker run -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:7.10.2```

6. Set vm.max_map_count to at least 262144

```docker-machine ssh
sudo sysctl -w vm.max_map_count=262144```

If this does't work go to 

```cd /Library/Containers/com.docker.docker/Data/vms/0
mkdir tty
sysctl -w vm.max_map_count=262144```

7. Give permission to elastic search 

```mkdir -p Data/elasticsearch
chmod 777 Data/elasticsearch```

`chgrp 1000 data/elasticsearch` -> Don't worry if this gives error

8. Start the report portal 

```docker-compose -p reportportal up -d --force-recreate```

9. Open in browser

```http://localhost:8080/ui/#login```

Login using : `superadmin\erebus`

10. Create a blank project in report portal

11. Clone the github project. 

12. Edit the reportportal.properties with the profile information of the project you created.

13. Run runner.xml file.

Listeners that can be used in project -> https://github.com/reportportal/agent-java-testNG#using-listeners-annotation
Report portal documentation -> https://reportportal.io/docs/Deploy-with-Docker
Elastic Search docker documentation -> https://www.elastic.co/guide/en/elasticsearch/reference/7.10/docker.html#_set_vm_max_map_count_to_at_least_262144


Dependency used :

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
