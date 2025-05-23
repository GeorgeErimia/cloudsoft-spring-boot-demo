# Configuring VMs on Windows

## This guide will help you configure your AMP instance, as well as your BYON network VMs for use with Cloudsoft AMP

> [!NOTE]
> We're about to configure these VMs similar to how I configured them to test this app.

## Prerequesites
In order to configure and run your VMs, you need the following software:
- VirtualBox
- Vagrant

## Steps
1. Download the contents of this repository: https://github.com/cloudsoft/amp-vagrant.git
> [!NOTE]
> Check the documentation over there, too. It contains additional information on how to configure servers and what IPs they're hosted on.

2. Unzip the archive
3. Download <code>servers.yaml</code> from <a href="https://github.com/GeorgeErimia/cloudsoft-spring-boot-demo/releases/download/vagrant-setup/servers.yaml">here</a>
4. Replace the original <code>servers.yaml</code> with the one you've just downloaded.
> [!TIP]
> Depending on your hardware specifications, you may need to change the <code>cpus</code> and <code>ram</code> values inside <code>servers.yaml</code>, for each VM.

5. Open a CMD window and navigate to the folder that contains <code>Vagrantfile</code>
6. Execute the following command: <code>vagrant up amp byon1 byon2</code>
> [!NOTE]
> The <code>servers.yaml</code> file contains four BYON VMs, but for our application, we can use only two.
> If you want to launch all VMs at once, you can use <code>vagrant up</code> without any VM specification.
 
7. Wait for all of them to finish installing and launching.
8. After all of them are finished, check their status using <code>vagrant status</code>


## Problems you might encounter
