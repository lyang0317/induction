# Git

# 命令
* reset 直接回退操作
  * reset后强制push到远程，其他人的本地版本执行git reset --hard origin/分支名进行强制同步
* revert 反向新生成一个提交作为回退操作
* merge 合并后记录原始合并分支
* rebase 合并后形成一条分支
    * rebase--add--continue--commit
* git diff Head^^或git diff Head~2
    * 未add，可直接git diff 文件名
    * add未commit，可git diff Head 文件名
    * commit，需要git diff Head + ^ 或者~1
* ^2代表第二个父节点 ~2代表回退2个提交的地方
* git branch -d  git checkout
* git log --pretty=oneline 
* git reflog --date=local | grep 分支名 查看分支历史