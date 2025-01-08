# codetree
python algorithms with code tree

# 원본 repository 가져오기
1. 원본 Repository를 'upstream'이라는 이름으로 추가
git remote add upstream https://github.com/geultto/daily-solvetto.git

2. 잘 등록되었는지 확인
git remote add upstream https://github.com/devyulbae/daily-solvetto.git

3. upstream 리포지토리의 변경사항 가져오기
git fetch upstream

4. 로컬 브랜치에 변경 사항 적용하기(Merge)
git checkout main  # 작업 중인 main(또는 master) 브랜치로 전환
git merge upstream/main  # upstream/main 브랜치를 내 로컬 main 브랜치로 병합

4. 로컬 브랜치에 변경 사항 적용하기(Rebase)
git checkout main  # 작업 중인 main(또는 master) 브랜치로 전환
git rebase upstream/main  # upstream/main 을 내 로컬 main에 리베이스

5. 깃허브(fork 저장소)에 반영하기
git push origin main
