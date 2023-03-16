# Welcome to Angular

## How to start
1. Create a new app
> At command type -> `ng new [AppName]`

2. Create Components
> At command tpye -> `ng g c components/[Component name]`

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