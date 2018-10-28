# Git

# 命令
* reset 直接回退操作
* revert 反向新生成一个提交作为回退操作
* merge 合并后记录原始合并分支
* rebase 合并后形成一条分支
    * rebase--add--continue--commit
* git diff Head^^或git diff Head~2
    * 未add，可直接git diff 文件名
    * add未commit，可git diff Head 文件名
    * commit，需要git diff Head + ^ 或者~1
* git branch -d  git checkout
* git log --pretty=oneline