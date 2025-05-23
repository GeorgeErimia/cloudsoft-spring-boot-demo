# Cloudsoft Spring Boot Demo
This is a Spring Boot app that can be deployed and managed via Cloudsoft AMP. It's a basic user management system that connects to a databases and executes CRUD operations. 

The application and database are to be hosted separately on two different VMs, but they can run on the same VM if you want. The point of this project is to demonstrate how you can deploy different application blueprints to different machines with Cloudsoft AMP.

## How to run the app
You can get the source code if you just want to try it without deploying, or fork the repo if you want to make modifications to it.

## Deploying to AMP - What you'll need
- An instance of Cloudsoft AMP (Mine was hosted on a VM running CentOS9)
- A location to deploy

    !!! I used two local VMs running Ubuntu 22.04, configured with Vagrant, but you can use any type of location, as long as it runs Ubuntu 22.04 or similar. If your locations are different from these, you can configure them accordingly, either via AMP GUI or by modifying the YAML.

- AMP CLI \(not necessary if you deploy via AMP GUI\)

!!! You can download AMP CLI by going to the AMP hosted address \(typically localhost:8081\), click on the 9 dots in the top right and go to 'CLI Download' and get the CLI for your OS.

### Deploying via GUI

1. Go to the <a href="https://github.com/GeorgeErimia/cloudsoft-spring-boot-demo/releases/"> Releases </a> section of this repo and download the YAML files (check out the description of each release, some of them have important info related to the current issues and how to work around them)


2. In the AMP GUI, go to Blueprint Composer and select the YAML tab

3. Copy and paste the YAML from <code>postgresql.yaml</code> to the blueprint, configure your locations (if yours are different) and click "Deploy".

4. Same thing with <code>spring-boot-app.yaml</code>

5. Check the Inspector to see if everything works accordingly. 

### Deploying via CLI 

!!! This guide assumes that you have AMP CLI for Windows \(also called br.exe\)

1. Go to the <a href="https://github.com/GeorgeErimia/cloudsoft-spring-boot-demo/releases/"> Releases </a> section of this repo and download the YAML files (check out the description of each release, some of them have important info related to the current issues and how to work around them)

2. Make sure that <code>postgresql.yaml</code> and <code>spring-boot-app.yaml</code> are in the same directory as <code>br.exe</code>

3. Configure your locations in both YAML files.

4. Open a CMD window, go to the directory that contains <code>br.exe</code> and the YAML files.

5. Login to AMP by executing:

    <code>br login http://\<your_amp_address\></code> - replace \<your_amp_address\> with the address that AMP is hosted on \(typically <code>localhost:8081</code>)

    !!! You will probably be required to enter the credentials. If you haven't configured any, the default username and password are <code>admin</code> and <code>password</code>.

6. Deploy the database using by executing:

    <code> br deploy postgresql-db.yaml </code>

7. Deploy the Spring Boot app by executing:

    <code> br deploy spring-boot-app.yaml </code>

8. If you don't have access to AMP's GUI, you can check the deployment status by executing:

    <code> br app </code>






