# kubernetes demo
Some minimal apps for kubenetes demos, and presetatnion pointers

## Part 1 - the cloud

1. It is a cheap way of running your applications on the public internet
   - No hardware hassle
   - No system downtimes
   - Pay per use rather than pay all the infrastructure upfront

2. It is an easy to scale applications in the cloud
   - Easily adapt to the number of users
   - Easy to conduct experiments in a “minimally destructive way”

3. The CFO is happy when he has no fixed costs!


4. What is a cloud application?
   - It is an _orchestra_ of _services_, running on a _for-rent infrastructure_ (with sla guarantees)


5. Where is the cloud?
   - There are multiple (three) cloud vendors, each one with some differentiation in price and services
   - They compete to offer services, and they try to vendor lock their users
   - A common “language to express cloud applications” has emerged, and that is kubernetes. (hero)

6. Why kubernetes?
   - It is a vendor independent way of expressing “cloud application” so we do not get swamped with only one vendor, without being able to easily switch “cloud”


Kubernetes is a container orchestrator

## Part 2 - Containers
1. In order to see and access the physical resources, a process has to go through the kernel
   - What would happen if the kernel would offer differnt levels of reality?
   - Always been in kernel, from the chroot
   - A process, normally run by a Linux kernel, that sees the world in a “particular way”

2. Namespaces
   - The name points at something different inside a context
   - There are some functionalities that the kernel can “restrict” from a process. Such functionalities are said to have “namespaces”
   - A namespaced functionality is like a “artificially restricted” view on the full resource

3. Namespaces as level of isolation between processes
   - The kernel "lies to process" by offering a partial view of the world
   - For security reasons, so that the processes can be segregated, and their interaction and rights can be kept in check
   - All the containers, still run on the same machine, but they do not see each other

4. What is a Linux Container
   - A process, normally run by a Linux kernel, that sees the world in a “particular way”
   - All the containers, still run on the same machine, but they do not see each other
   - They all share the same OS, so they are much cheaper to run than a full virtualization
   - There are some functionalities that the kernel can “restrict” from a process. Such functionalities are said to have “namespaces”
   - A namespaced functionality is like a “artificially restricted” view on the full resource

5. Images and dependencies
   - Of all the resources that the kernel “namespaces” to a process, one of the most impactful is the file system
   - We package our applications with “images” of our application, with “already installed” all dependencies and a sensible default configuration
 
6. Summary
   - The Linux kernel can “encapsule” a process, so that it sees only some “name spaced” resources
   - We call this encapsulated environment “linux container”
   - We ship applications as “already installed, ready to run” images
   - Like “instant soup in 10 seconds, add hot water”, where hot water is a Linux kernel

   - _*Our “recipe” is made of many containers, that need to communicate between each other, enter “Part 3 - Kubernetes”*_

## Part 3

1. Kubernetes
   - It is a container orchestrator
   - Has APIs: It is a “server” program, in the sense that the main interaction interface is a proxy for a web application
     - If you can do it, you can automate it!
   - Supports
     - Running apps, like web applications
     - Running jobs, like “every first Monday of the month, run something”
     - Having “names” for services

2. Kubernetes "RULEZ"
   - The name comes from the Greek for “the guy that steers the ship”, where by ship we mean a group of containers
   - I used to think it came from the “borg cube”, because it is the open source version of a Google’s software called “Borg”.
   - It has the Origin of "Kubernator"

3. Has APIs
   - Components (Server)
      - **API** Server: lets you control the cluster
      - **ETCD:** stores and shares the configuration of the cluster
      - **Scheduler:** decides where (physically) a new pod should run
      - **Controller** manager: manages replications, endpoints, security …
   - Components (Node)
      - **Kubelet:** prepares the field for pods to run
      - **Container** engine: runs the pods, the way kubelet tells it 
      - **Kube-proxy:** keeps the host network configuration aligned with kubernetes

4. Kubernetes Mini-summary
   - Runs a bit differently in the two types of nodes, but with the intent of “summing” the capabilities of the nodes
   - The “orchestra director” is there to make easy to express and run complex configurations
   - There are 2 “building blocks” concepts of the orchestra,
      - The single member
         - Microservices are single members
         - PODs!
      - How to reach members
         - Services

5. PODs
   - A pod runs one or more containers, each with its own context, but “virtually” on the same machine
      - Containers in a pod can communicate via file system / normal IPC
      - They can address each other as 127.0.0.1
   - It is like “the applications that must run on an application node”
      - They are like beans in a pod
         - Are born together
         - Are in the same physical machine
         - Same lifecycle
      - Inside the cluster, each pod has a dynamically assigned IP address, and communicates with other pods via TCP/IP (as if they were machines in a subnet)
      - Sort of “Virtual machine - let”

6. Services
   - Pods are created with a new IP for each new spin up
   - How can you find them?
      - Labels and selectors
      - Services:
         - Abstract ways of “grouping” pods that provide the same service
         - Load balances between pods, allowing for scaling
         - …It is actually just an iptables rule



