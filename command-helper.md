# Command helper

## Hello world

```bash
kubectl run -t -i greet --image=busybox --restart=Never --command -- echo "Hello World!"
```

## Sleeper process

```bash
kubectl apply -f sleeper.yaml
```

```bash
kubectl exec -ti app -- bash
```

## Example server

```bash
kubectl apply -f webservice.yaml
```

and

```bash
kubectl apply -f client.yaml
```

check for the ip

```bash 
kubectl exect -ti client -- bash
```

and in the cli

```bash
curl <ip>
```

