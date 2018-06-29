# BetaGame
game code repository


---------------------------
How to download the game files(project)?

Steps if you're using Windows:
1. Open your cmd and write the following
2. git clone https://github.com/SamuelRuizGero/beta-game.git
3. Open Netbeans, click "File" -> "Open Project" and then find the folder where you just downloaded the repo
NOTE: You can find where you downloaded the repo by going to your cmd and typing "start ." this will open the folder that contains the files you downloaded from Github.

---------------------------
How to upload your changes?

Do the following:
1. git status                    :(optional) this will list all new files and modified files to be committed
2. git add .                     :Snapshot the file in preparation for versioning
3. git commit -m "<description>" :Records file snapshots permanently in version history
4. git push                      :push the changes to the remote repository

NOTE: you can combine steps 2 and 3 by typing: git commit -a -m "<description>"


---------------------------
How to get the updates made by your team members?

1. git pull           :it will automatically fetch and merged the changes from the remote branch(project/files) into your current branch(project/files).


--------------------------
TRY TO AVOID MERGE CONFLICTS - YOU DON'T WANT TO WASTE 4 HRS TRYING TO SOLVE THIS PROBLEM.
Don't overwrite other peoples code without first telling them

Check is youtube link:
Git Tutorial: Fixing Common Mistakes and Undoing Bad Commits
https://www.youtube.com/watch?v=FdZecVxzJbk&t=913s