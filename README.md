# AllowHostname

특정 서버 주소 허용

---
### 플러그인 소개
* 원하는 서버 주소로만 접속하도록 할 수 있습니다.
* Weirdhost(위어드호스트)에서 사용하기 위해 제작되었습니다.
---
### 사용법
1. **플러그인 설치**
   - 1-1. 플러그인을 다운로드합니다 : [다운로드](https://github.com/cape12/AllowHostname/releases/download/v1.0/AllowHostname.jar)

   - 1-2. 서버의 **plugins** 폴더에 넣어주세요.

   - 1-3. 재시작 혹은 `reload confirm`을 입력하세요.

   - 1.4. 서버의 **plugins** 폴더에 **AllowHostname** 이라는 폴더가 생성되었는지 확인하세요.

2. **설정 파일 수정**
   - 2-1. 허용하고 싶은 서버 주소로 서버에 접속합니다. (정상적으로 설치가 되었다면 접속이 끊김)

   - 2-2. 서버 콘솔을 확인하면 `[AllowHostname] 유저 접속 실패 - <플레이어이름> - <서버주소> - 금지된 서버 주소 사용`이라고 적혀있을건데, 그 중에서 <서버주소> 부분을 복사합니다.

   - 2-2. 그 다음으로 **plugins/AllowHostname**에 있는 **config.yml**을 다음과 같이 수정합니다.
      ```
      allow-hostname:
      - "server-address"
      ```
      `server-address`를 아까 복사한 걸로 붙여넣습니다.

     ※ 큰따음표(")를 제거하지 마세요!

   - 2-3. 마지막으로 서버를 재시작 혹은 `reload confirm`을 입력합니다.
---
### 번외
만약 서버 콘솔에 `[AllowHostname] 유저 접속 실패 - <플레이어이름> - <서버주소> - 금지된 서버 주소 사용` 이와 같이 뜨는게 싫으시다면 **config.yml**에서 아래와 같이 수정합니다.
```
output-log: true
```
