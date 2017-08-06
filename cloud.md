# One of the current hypes: Cloud + Microservices

## overview
- Amazon: huge datacenter to run their main business
- perfected IT infrastructure
- rent it to other companies to run their applications on it
- other vendors followed: Google, Microsoft
- best practices, books, software designs, software, ... for developing "in the cloud"
- game changer

## concepts
### accessibility
- (web-)interfaces make it extremely easy to 
    - buy infinite computing power
    - deploy from all-over the world   
- TODO show live demo or screenshots from registration to first deploy of pre-developed application

### hyperscale
- __THE__ main concept
- vendors built huge, efficient datacenters to support own IT services
- way more efficient than server-room in small companies
- hard- and software setup to scale + software to allow for instantaneous (and automatic) scaling
- TODO show live demo or screenshot to setup scaling at web interface

### efficiency
- the more clients a datacenter has, the more efficient it runs  
- containerisation + virtualization: applications can be deployed to the best-fitting server
- if application needs more memory / CPU / database, just deploy it somewhere else / add another service
- => lower prices for everyone => more customers => better service => lower prices => Amazon calls this the "virtuous cycle"

## pyramid of layers
### SaaS = software as a service
= software specifically designed to run in cloud)
- not directly part of cloud, but nevertheless mentioned because most people don't know that these services also run "in the cloud" 
- exmaples: Salesforce, Yahoo!Mail, Hotmail, GMX, Microsoft Office 365

### PaaS = platform as a service
= additional abstraction layer: set of tools and services to make creating applications in the cloud easier
- Examples: Pivotal CloudFoundry, Windows Azure, Amazon Elastic Beanstalk, Google App Engine 
- technology: services like loadbalancer, databases, queues, search engines (ElasticSearch)

### IaaS = infrastructure as a service
= clients set up virtual servers and storage
- Examples: Amazon EC2, Google Cloud Storage, OpenStack
- technology: containers, images

## history lesson
- Amazon 
    - first because offering cloud services since 2006 (first vendor)
    - first services in 2006: Elastic Compute Cloud (EC2) for virtual servers + Amazon Simple Storage Service (S3) for file storage
    - at first single developers, later companies like Netflix, Airbnb, Slack and the CIA (not a company though)
    - because of long history of developing features for their cloud, Amazon = de facto standard of cloud
- Microsoft
    - cloud-projects since 2000s, but not published - AWS in 2010
    - with a lot of effort: Azure now strong player
    - Azure first only PaaS, later IaaS, too
    - Microsofts selling points:
        - Windows heavily used world-wide
        - easy integration into Microsoft-cloud
        - enterprise know-how
        - huge number of existing customers that can be given discounts to use Microsoft cloud instead of Amazon   
- Google
    - 2008 Google App Engine
    - 2013 renamed to "Google Cloud Platform"
    - edge in developer-trust compared to Microsoft (because of publications)
- other companies [see here](http://www.businessinsider.de/why-amazon-is-so-hard-to-topple-in-the-cloud-and-where-everybody-else-falls-2015-10?r=US&IR=T)  

## current situation
- individual developers and small businesses gained access to same computing power and infrastructure than large businesses => HUGE gamechanger: big companies' costly datacenters = separation between "big company" and "the rest" => that's now gone!

### market
- market share (2015):
    - Amazon 27.2%
    - Microsoft 16.2%
    - IBM 11.8%
    - Google 3.6%
    - Oracle 2.7%
    
# Sources
- http://www.businessinsider.de/why-amazon-is-so-hard-to-topple-in-the-cloud-and-where-everybody-else-falls-2015-10?r=US&IR=T