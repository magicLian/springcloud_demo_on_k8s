# springcloud-demo-on-k8s

### Prepare
* Java 1.8
* Spring boot 2.0.3 RELEASE
* Spring cloud Finchley.RELEASE
* Maven-docker-plugin 1.0.0
* Kubernetes 1.13
* Kube-dns
* Docker 18.06.1-ce


### Service

+ eureka-server
+ service-zuul
+ service-api
+ service-tp
+ config-server

### Build and Docker

`mvn clean package docker:build`

```docker push xxxxx```


### Deploy

`kubectl create/apply -f deploy-file/<xxx>.yaml`

`kubectl get/delete deploy,pod,svc --all-namespaces/-n default`

`kubectl describe pod POD_ID`

`kubectl logs -f POD_ID`

	kubectl exec -it busybox sh
    nslookup eureka-server
   
	
### Test

check the services whether join in eureka-server and config-server runs well.

	eureka-server portal test : http://IP:Port
	
	config-server and client test : http://IP:Port/custom-config/dev




