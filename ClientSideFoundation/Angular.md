# Welcome to Angular

## How to start
1. Create a new app
> At command type -> `ng new [AppName]`

2. Create Components
> At command type -> `ng g c components/[Component name] --flat --skip-tests`

3. Create Service
> At command type -> `ng g s service/[Service Name] --flat --skip-tests`

4. Create Enviroments
> At command type -> `ng generate environments`

## Files that are inside the app
1. app.module.ts
> Components should appear in the declarations

> Imports is where you import your modules

> Services created will be put in the providers

2. app.components.ts
> This will be your **Parent** component

> Here is where you will work on your parent

## How to do stuff

### How to make a form
1. Create a new form group `form!: FormGroup`
2. ngOnit and create the form
```
ngOnInit(): void {
    this.form=this.fb.group({
      country: this.fb.control<string>('',[Validators.required]),
      category: this.fb.control<string>('',[Validators.required])
    })
}
```
3. Link up the form by `[formGroup]="form"`
4. Link up the fields by `formControlName="country"`

### Show html page
1. This will be done in the `app.component.html`
2. Add other components in by `<app-[other component name]></app-[other component name]>`

## Part of library that helps


## Methods to check output
1. Use inspect console
> To use you will need `console.info('message',obj)`

## Routing
1. Do the usual `ng new [AppName]`
2. When asked about angular routing key `y`
3. Angular routing file will be added

## Theory

### The different brackets
1. `[test] = "something" `
> Using a square bracket, something will be stored into test
2. `(test) =  "something"`
> Using a curve bracket, when the test function triggers, it will store the value into something
3. `[(test)] = "something"` 
> Using both together will allow two way data passing.

### Prevent read only client
1. Enter this in command in the client dir `rm -rf .git`

## Using DigitalOcean
1. Login
2. Under manage go to spaces
3. Under create -> create spaces
4. Select singapore as the region
5. Dont select CDN
6. Create the space
7. Go back
8. Go to manage keys
9. Generate key

## Dependency
```
<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
            <groupId>com.amazonaws</groupId>
            <artifactId>aws-java-sdk-s3</artifactId>
            <version>1.12.435</version>
        </dependency>
		<dependency>
			<groupId>org.glassfish.jaxb</groupId>
			<artifactId>jaxb-runtime</artifactId>
			<version>4.0.2</version>
		</dependency>
		<dependency>
			<groupId>javax.xml.bind</groupId>
			<artifactId>jaxb-api</artifactId>
			<version>2.4.0-b180830.0359</version>
		</dependency>
		<dependency>
            <groupId>com.mysql</groupId>
            <artifactId>mysql-connector-j</artifactId>
            <version>8.0.32</version>
        </dependency>
		<-For joda time->
		<dependency>
			<groupId>joda-time</groupId>
			<artifactId>joda-time</artifactId>
			<version>2.12.1</version>
		</dependency>
```


ng serve --proxy-config proxy.config.js


ng build - dist copy to sprinboot static folder