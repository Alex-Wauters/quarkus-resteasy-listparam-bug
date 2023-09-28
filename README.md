Project created from `quarkus create`, with minimal changes to support bug issue reported on https://github.com/quarkusio/quarkus/issues/36170

Launch the project with JDK21 and make a request to http://localhost:8080/hello and inspect the logs

Output:

```
2023-09-28 12:05:35,192 DEBUG [org.jbo.res.rea.cli.log.DefaultClientLogger] (vert.x-eventloop-thread-1) Request: GET http://localhost:8080/exampleAPI?status=%5BIN_PROGRESS%2C+PUBLISHED%5D Headers[Accept=text/plain;charset=UTF-8 User-Agent=Resteasy Reactive Client], Empty body
2023-09-28 12:05:35,197 DEBUG [org.jbo.res.rea.cli.log.DefaultClientLogger] (vert.x-eventloop-thread-1) Response: GET http://localhost:8080/exampleAPI?status=%5BIN_PROGRESS%2C+PUBLISHED%5D, Status[200 OK], Headers[content-length=47 Content-Type=text/plain;charset=UTF-8], Body:
Received request - see console logs for params 
```

Expected output for the status query param (when launched with JDK17)

```
2023-09-28 12:17:41,933 DEBUG [org.jbo.res.rea.cli.log.DefaultClientLogger] (vert.x-eventloop-thread-1) Request: GET http://localhost:8080/exampleAPI?status=IN_PROGRESS&status=PUBLISHED Headers[Accept=text/plain;charset=UTF-8 User-Agent=Resteasy Reactive Client], Empty body
2023-09-28 12:17:41,939 DEBUG [org.jbo.res.rea.cli.log.DefaultClientLogger] (vert.x-eventloop-thread-1) Response: GET http://localhost:8080/exampleAPI?status=IN_PROGRESS&status=PUBLISHED, Status[200 OK], Headers[content-length=47 Content-Type=text/plain;charset=UTF-8], Body:
Received request - see console logs for params 
```