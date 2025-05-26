# Cloudsoft Spring Boot Demo
This is a Spring Boot app that can be deployed and managed via Cloudsoft AMP. It's a basic user management system that connects to a PostgreSQL database and executes CRUD operations. 

The application and database are to be hosted separately on two different VMs, but they can run on the same VM if you want. The point of this project is to demonstrate how you can deploy and manage different application blueprints on different machines (locations) with Cloudsoft AMP.

## How to run the app
You can get the source code if you just want to try it without deploying, or fork the repo if you want to make modifications to it.

Make sure you configure application.properties to match your requirements.

## Deploying to AMP - What you'll need
- An instance of Cloudsoft AMP (Mine was hosted on a VM running CentOS 9)
- A location to deploy

> [!NOTE]
>I used two local Ubuntu VMs, configured with Vagrant, but you can use any type of location, as long as it runs Ubuntu 22.04 or similar. If your locations are different from these, you can configure them accordingly, either via AMP GUI or by modifying      
 the YAML. If you want to configure the instances just like I did, refer to <a href="https://github.com/GeorgeErimia/cloudsoft-spring-boot-demo/blob/main/Configure%20VMs.md">VM Configuration Guide</a>

- AMP CLI \(not necessary if you deploy via AMP GUI\)

> [!TIP]
> You can download AMP CLI by going to the AMP GUI, click on the 9 dots in the top right and go to 'CLI Download' and get the CLI for your OS.

### Deploying via GUI

1. Go to the <a href="https://github.com/GeorgeErimia/cloudsoft-spring-boot-demo/releases/"> Releases </a> section of this repo and download the YAML blueprints (check out the description of the release you're getting, some of them have important info related to the current issues and how to work around them)

2. In the AMP GUI, go to Blueprint Composer and select the CAMP Editor tab

3. Copy and paste the YAML from <code>postgresql.yaml</code> to the blueprint.

4. Configure your locations (if yours are different) and click "Deploy".

5. Same thing with <code>spring-boot-app.yaml</code>

6. Check the Inspector to see if everything works accordingly. 

### Deploying via CLI 

> [!IMPORTANT]
> This guide assumes that you have AMP CLI for Windows \(also called br.exe\)

1. Go to the <a href="https://github.com/GeorgeErimia/cloudsoft-spring-boot-demo/releases/"> Releases </a> section of this repo and download the YAML blueprints (check out the description of the release you're getting, some of them have important info related to the current issues and how to work around them)
   
2. Make sure that <code>postgresql.yaml</code> and <code>spring-boot-app.yaml</code> are in the same directory as <code>br.exe</code>

3. Configure your locations in both YAML blueprints (if necessary).

4. Open a CMD window, navigate to the directory that contains <code>br.exe</code> and the blueprints.

5. Login to AMP by executing:

    <code>br login http://\<your_amp_address\></code> - replace \<your_amp_address\> with the address that AMP is hosted on \(typically <code>localhost:8081</code> if you're hosting it locally)

> [!IMPORTANT]
> You will probably be required to enter the credentials. If you haven't configured any, the default username and password are <code>admin</code> and <code>password</code>.

6. Deploy the database by executing:

    <code> br deploy postgresql-db.yaml </code>

7. Deploy the Spring Boot app by executing:

    <code> br deploy spring-boot-app.yaml </code>

8. If you don't have access to AMP's GUI, you can check the deployment status by executing:

    <code> br app </code>

### After deployment

You can access the web app by going to <code>http://<spring_boot_app_address>:8080/</code>

To get the app's address:
- Go to Inspector
- Find and click on <code>Spring Boot App</code> under Applications
- Go to Location and copy the <code>Address</code>

### ADDITIONAL: Adding to the AMP Catalog (CLI)

You can add both blueprints to the AMP Catalog. In order to do that, follow these steps: 

1. Go to the <a href="https://github.com/GeorgeErimia/cloudsoft-spring-boot-demo/releases/"> Releases </a> section of this repo, and download <code>catalog.bom</code>
2. Place it in the same folder as your YAML blueprints and br.exe
3. Open a CMD window, navigate to the directory that contains <code>br.exe</code>
4. Login to AMP by executing: <code>br login http://\<your_amp_address\></code> - replace \<your_amp_address\> with the address that AMP is hosted on \(typically <code>localhost:8081</code> if you're hosting it locally)
5. Execute the following: <code>br catalog add .</code>

After that, you can use them straight from the AMP GUI, by going to <code>Blueprint Composer</code> and searching for them in the <code>Entites tab</code>.

These two entities should have the following names: <code>Spring Boot 2T APP</code> and <code>Postgresql 2T Database</code> respectively.






