GIT SUMMARY
============

BASICS
------
unstaged         -        staged            -           comitted 
                add
                rm


commit:
-------
head (where you are now -- moves with checkout)
 |
 |
branch
 |
 |
commit   --  tree  -- blob1
                   -- blob2
         --  parentcommit


Most used commands:
--------------------
# show commits where file was adapted (note shows only current branch):
git log --pretty=format:"%h - %ce, %cd : %s" --graph --stat (tests/startplaybook.sh)

# diffs:
git difftool --tool=vimdiff2 (--staged)

# pushen:
git push origin --tags

# branches: (fetch gets the remote changed files, but does not touch the working directory, also fetches remote branches but does not create these automagically)
git fetch --all; git branch -vv
git checkout master
# show commits in origin/master that are not in master (if we are behind)
git log master..origin/master
git merge origin/master

# diff commits between master & test branch
git log master...test --pretty=format:"%h - %ce, %cd : %s" --graph --stat 

Create a new repository
git clone https://XXXXXX@host.XXXX./....git
cd ansibletest2
touch README.md
git add README.md
git commit -m "add README"
git push -u origin master
git status
git log

Existing folder
cd existing_folder
git init
git remote add origin ssh://..git
git add .
git commit
git remote -v
(seems I need to create the project first)
git push -u origin master

Existing folder
cd ~/ansible/ansibletest3
git init
git remote add origin ssh://...git
git add .
git commit
git remote -v
(seems I need to create the project first)
git push -u origin master

fix conflict issue:
git pull ssh://git@....git master
CONFLICT (directory/file): There is a directory with name test-playbooks in HEAD. Adding test-playbooks as test-playbooks~95bb37edeeddbdcc7d3684efc072a298517771d1
Automatic merge failed; fix conflicts and then commit the result.


you can do a force push:
git push -f origin

OR 
https://stackoverflow.com/questions/10298291/cannot-push-to-github-keeps-saying-need-merge


Existing Git repository
cd existing_repo
git remote add origin http://....git
git push -u origin --all
git push -u origin --tags


GIT READING
===========
http://wiki.eclipse.org/EGit/Git_For_Eclipse_Users

head, tip (tip of current branch)
branch=changeset.  default is master (trunk)

branches are quick: for example 1 per fix is ok (or feature.
DCVS (git) knows where branch began (trhough hash), so can apply to file as it was and then roll forward to where we are now. 

git init (create project)
index file: files would be committed
git add: add files (or git commit -a)

git branch: create new branch (no options is view)
git checkout: switch branch (-b create)
$ git log --graph --oneline # Shows graph nodes (not much here) and change info
* 9b1939a Updated README.txt
* 0dd1f35 Added README.txt
$ git checkout -b french 0dd1f35 # create and switch to a new branch 'french'

Merge
------
$ git branch # See what branches we've got
  french
* master
  web
$ git merge web # pull 'web' into current branch 'master'
Merge made by recursive.
 index.html |    1 +
 1 files changed, 1 insertions(+), 0 deletions(-)
 create mode 100644 index.html

git: works with changeset (hash of changes + hash of previous)

# some other useful commands:
git show master
git show origin/master
git branch
# show diff between master & origin/master
git log master..origin/master
# if there are new changes then following command should do a fast forward merge:
git merge origin/master
https://git-scm.com/book/en/v2/Git-Tools-Advanced-Merging
 show current state
git log --graph
git log --graph --oneline
git log --pretty=format:"%h %s" --graph
git log --oneline --decorate
git log --online --decorate --graph --all
git blame -L 1,2 test (see who changed file test in lines 1 until 2)

# show remote repo: (default name is origin)
git remote -v
git ls-remote origin
git remote show

git push origin

#NOT !/bin/bash
#
##################################################################################
#
# description: README file, describes some usuful GIT commands
# usage: do not invoke this file as it contains git commands
# author: Tom Cleymans
# date: 13/02/2018
# version: 1.0
# changes:
# end description
##################################################################################
#
# Documentation/usage
# ===================
# some useful GIT documentation to start with
#
# Guide
# =====
# useful guide to read:
# 1. basic concept (diff SVN)
# https://wiki.eclipse.org/EGit/Git_For_Eclipse_Users
# 2. best guide to read:
# https://git-scm.com/book/en/v2/Git-Basics-Viewing-the-Commit-History
# chapter 2 & 3 are interesting
#
# git sheat sheet
# ===============
# this section contains most useful commands for when working with git
#
# start point:
# actions taken for cloning git repository (creates directory ansibletest2)
git clone ssh://../ansibletest2.git
cd ansibletest2
touch README.md
# this is to stage the readme file
git add README.md
# above means the change in the readme file we made is ready to commit
"GITREADME.txt" 133L, 3236C                                                    

# any change after add to the readme file will not be committed
# see what is unstaged (note does not show staged !!)
git diff
# see what is staged (after last commit)
git diff --staged
git difftool --tool-help

git commit -m "add README"
git push -u origin master
# see status of current files (staged-- committed.. )
git status
7515524@s51lvrw:~/ansible/ansibletest1 $ git status -sb
## master...origin/master [ahead 1] (here we are 1 commit ahead of master)

git log
git log --stat

# show branches:
git branch
git branch -v (laatste commit op elke branch)
git branch --merged (shows branches are already merged)
git branch --no-merged

# best is to:
# work with branches:
# create branch & goto (checkout)
git checkout -b test
git branch test (does not move to the branch)
git checkout test (moves to the branch test)
# note switching branches best in clean state (no unstaged/staged)
# otherwise stashing & clening
# 2 merge
git checkout master
git merge test
# if conflict
git status
# fix the file
git add
# or
git mergetoo

## ffwd test branch (merge)
# for when making very small change (like hotfix)
# assuming you are on test
# go2master:
git checkout -b master 
git merge test (merge the test to master)
(now master pointer is up to last commit)
git branch -d test (delete test branch)

# zelfde als boven voor 3way merge
# indien conflicten: git mergetool, of manueel fixen en dan git add (git status om issues te zien)

# if you don't have a clean working directory:
7515524@s51lvrw:~/ansible/ansibletest1 $ git merge origin/master
Updating af97a58..e5d2778
error: Your local changes to the following files would be overwritten by merge:
        ansible.cfg
Please, commit your changes or stash them before you can merge.
Aborting





# rebasing
!!!!! Rebase geen commits die je gepusht hebt naar een publiek repository.

https://git-scm.com/book/nl/v1/Branchen-in-Git-Rebasen
git checkout mybranch
git rebase master
(hierboven zit je op mybranch en je gaat changes applied op mybranch replayen op de laatste commit van de master branch)
(note je zit nog steeds op mybranch die nu eigenlijk is gereplayed op de master branch)
(note: de master head gaat nog verwijzen naar de vorige commit, dus moet je een FFWD merge doen:)
git checkout master
git merge mybranch

#or
# take the client branch, (diff from server branch) and apply on master
git rebase --onto master server client


# apply patches
git apply(only with diff files) of met git am (format-patch).
# git apply:
#Het handelt ook het toevoegen, verwijderen, en hernoemen van bestanden af als ze beschreven staan in het git diff formaat, wat patch
# niet doet 
git apply --check ddd.patch
# use 3way merge where possible (if the patch is based on a commit that is available, otherwise it is not possible)
git am -3 0001-seeing-if-this-helps-the-gem.patch

# show current state
git log --graph
git log --graph --oneline (shows branch- merge history)
git log --pretty=format:"%h %s" --graph (for format see git docu git help log https://git-scm.com/book/nl/v1/De-basis-van-Git-De-commit-geschiedenis-bekijken)
git log --oneline --decorate
git log --online --decorate --graph --all
git log (show all commits)
git log –p -2 (show diff of last 2 commits
git log --stat -2 (show stats of last 2 commits -- changed files +sha-1)
git log --pretty=oneline
git log --since=2.weeks --pretty=oneline
git log --pretty="%h - %s" --author=gitster --after="2008-10-01T00:00:00-0400" --before="2008-10-31T23:59:59-0400" --no-merges -- t
# chow commits in mybranch that are not in master
git log mybranch --not master
git log master..experiment (alle commits in experiment, that are not in master)
git log master..experiment (alle commits in experiment, that are not in master)
git log master...experiment (commits in master & experiment but not shared (so not the common ancestors)
git log origin/master..HEAD (alle commits in head, but not in remote origin/master (so what you will push))
git log refA refB --not refC (commits in refA&refB, but not in refC)
git log -S ZLIB_BUF_MAX --oneline (show commits that introduced ZLIB_BUF_MAX)
git diff master...mybranch (show changes in mybranches (comp to common ancestor in master)
!! De laatste veelgebruikte reeks-selectie syntax is de drievoudige punt syntax, wat alle commits specificeert die bereikbaar zijn door één van de twee referenties, maar niet door allebei !!
gitk (visual)

# resetting (undo changes): see https://git-scm.com/book/en/v2/Git-Tools-Reset-Demystified


# show remote repo: (default name is origin)
git remote -v
git ls-remote origin
git remote show 
git remote show origin

# working with remotes:
git fetch myremotesite (fetches but does not merge)
git pull myremotesite (fetches + merges)
git push origin master
git push origin :serverfix (serverfix verijderen)

# create branch locally that refs a remote branch:
git checkout --track origin/serverfix
git checkout -b sf origin/serverfix


# tags:
# show tags
git tag
# create annotated tag:
git tag -a v1.0 -m "version 1.0"
# tag a version in the past:
git tag -a 0.1 9fceb02
git show v1.0
# lightweight tag (only commit checksum stored)
git tag v1.1-lw
git show v1.1-lw
# note tags are not pushed to remotes, unless you do:
git push origin --tags

# alias/config:
git config --global alias.unstage 'reset HEAD --'
git config --global core.editor emacs
git config --global merge.tool vimdiff
git config --list
git unstage myfile
        
# git cherry-pick SHA1CODE
# add files
git add myfile (note the file will be staged, it will be the change in file at that point that will be committed)

tricks:
https://github.com/git/git/blob/master/contrib/completion/git-completion.bash.


# git internals
515524@s51lvrw:~/ansible/ansibletest3/.git/objects/fa $ git cat-file 4cdec8f423c60fabaec1bfc5c12564efb28484
usage: git cat-file (-t|-s|-e|-p|<type>|--textconv) <object>
   or: git cat-file (--batch|--batch-check) < <list_of_objects>

<type> can be one of: blob, tree, commit, tag
    -t                    show object type
    -s                    show object size
    -e                    exit with zero when there's no error
    -p                    pretty-print object's content
    --textconv            for blob objects, run textconv on object's content
    --batch               show info and content of objects fed from the standard input
    --batch-check         show info about objects fed from the standard input

7515524@s51lvrw:~/ansible/ansibletest3/.git/objects/fa $ git cat-file -t 4cdec8f423c60fabaec1bfc5c12564efb28484
fatal: Not a valid object name 4cdec8f423c60fabaec1bfc5c12564efb28484
7515524@s51lvrw:~/ansible/ansibletest3/.git/objects/fa $ git cat-file -p 4cdec8f423c60fabaec1bfc5c12564efb28484
fatal: Not a valid object name 4cdec8f423c60fabaec1bfc5c12564efb28484
7515524@s51lvrw:~/ansible/ansibletest3/.git/objects/fa $ git cat-file -p fa4cdec8f423c60fabaec1bfc5c12564efb28484
object 91a4567376aa523771edd3450e4c9ec83ae283b0
type commit
tag v1.0
tagger Cleymans Tom (100) <tom.cleymans@cm.be> 1521193152 +0100

version 1.0


git stash (save changes on stack without commit)
git stash list
git stash apply


7515524@s51lvrw:~/ansible/ansibletest1 $ git log --pretty=format:"%h - %ce, %cd : %s" --graph
*   af97a58 - 7515524@s51lvrw.cmc.be, Thu Mar 29 13:57:52 2018 +0200 : test merged branches
|\
| * af27d2a - 7515524@s51lvrw.cmc.be, Thu Mar 29 13:51:13 2018 +0200 : added test in test branch
* | c6d848a - 7515524@s51lvrw.cmc.be, Thu Mar 29 13:52:29 2018 +0200 : this is a commit from master
|/
* d9efb91 - 7515524@s51lvrw.cmc.be, Wed Mar 28 14:40:58 2018 +0200 : added new file test
* 74181af - tom.cleymans@cm.be, Wed Feb 7 13:19:49 2018 +0100 : added tmp directory
* 83f23c7 - tom.cleymans@cm.be, Wed Feb 7 13:19:10 2018 +0100 : fixed relative location of files
* 6828bc4 - tom.cleymans@cm.be, Tue Feb 6 17:12:11 2018 +0100 : move existing test to git
7515524@s51lvrw:~/ansible/ansibletest1 $ git branch
* master
  test
7515524@s51lvrw:~/ansible/ansibletest1 $ git branch -d test
Deleted branch test (was af27d2a).
7515524@s51lvrw:~/ansible/ansibletest1 $ git log --pretty=format:"%h - %ce, %cd : %s" --graph
*   af97a58 - 7515524@s51lvrw.cmc.be, Thu Mar 29 13:57:52 2018 +0200 : test merged branches
|\
| * af27d2a - 7515524@s51lvrw.cmc.be, Thu Mar 29 13:51:13 2018 +0200 : added test in test branch
* | c6d848a - 7515524@s51lvrw.cmc.be, Thu Mar 29 13:52:29 2018 +0200 : this is a commit from master
|/
* d9efb91 - 7515524@s51lvrw.cmc.be, Wed Mar 28 14:40:58 2018 +0200 : added new file test
* 74181af - tom.cleymans@cm.be, Wed Feb 7 13:19:49 2018 +0100 : added tmp directory
* 83f23c7 - tom.cleymans@cm.be, Wed Feb 7 13:19:10 2018 +0100 : fixed relative location of files
* 6828bc4 - tom.cleymans@cm.be, Tue Feb 6 17:12:11 2018 +0100 : move existing test to git



2DO
===
BITBUCKET/JIRA integration
bitbucket to jenkins (no jenkins pulling)

we use GitLab Community Edition 9.0.5
github vs gitlab (open source - but diff to move from svn to gitlab but free private --> best tommy) vs bitbucket(bought by atlassion -- integration with confluence & jira) 
(repository management systems ( issue tracking, pages ... ))

pull request feature (developer's review)


https://www.atlassian.com/git/tutorials/making-a-pull-request
best read:
https://git-scm.com/book/nl/v1/Aan-de-slag-De-basis-van-Git
