#! /bin/bash

git clone git@github.com:jmctee/ProjectStarter.git
mv ProjectStarter $1
cd $1

rm -Rf .git TODO README.asciidoc bootstrap.sh

git init
git add .gitignore build.gradle src
git commit -am "${1}: bootstrapped from https://github.com/jmctee/ProjectStarter"
git status
git log

gradle cleanIdea
gradle idea
gradle build

echo "Project ${1} now ready for use, open in IntelliJ Idea and got to town!"
