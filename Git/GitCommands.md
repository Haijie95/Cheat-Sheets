# Commands
1. Initialise
`git init`
2. Add the file to prep for uploading 
`git add .`
3. Commit to the push and add a comment
`git commit -m "msg"`
4. Check the status of the files (Red = not added, Green = added)
`git status`
5. Check the origin 
`git remote -v`
6. Pushing
`git push -u origing master`
7. Branching
`git checkout -b tester`
```
Purpose is to work on a version while not touching the present version
So as not to touch the Main
8. To return to main
`git checkout main`

# Git ignore file
1. create a .gitignore file
2.	`*.class` will ignore all class file
3.	`classes/**` will ignore all files in classes directory
4.	`*.tmp` will ignore tmp files
5.	`tmp_*` will ignore any file that start with tmp
6.	`*_txt` will ignore all txt files


