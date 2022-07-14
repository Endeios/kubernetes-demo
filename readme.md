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
