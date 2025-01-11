# Git

# 命令
* reset 直接回退操作
  * reset后强制push到远程，其他人的本地版本执行git reset --hard origin/分支名进行强制同步
* revert 反向新生成一个提交作为回退操作
  * 解决后期功能分支合并到主分支代码丢失
    1. 基于主分支建立新分支
    2. 新分支上revert前一次revert操作
    3. 到功能分支合并新分支
    4. 到主分支合并功能分支
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
* git reflog --date=local | grep/findstr 分支名 查看分支历史(第一个checkout moving from代表从哪个分支来的)

# issue
  1. OpenSSL SSL_read: SSL_ERROR_SYSCALL, errno 0 
     1. 设置代理 git config --global http.proxy http://10.38.34.162:3128
     2. 取消代理 git config --global --unset http.proxy