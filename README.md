# Slack Notifier

- 슬랙으로 알림을 보내는 PoC 코드입니다
- 두가지 방식을 이용해서 Message 를 전송합니다.
  - 1 `SDK` 를 이용해서 보내는 요청
  - 2 `HTTP API` 를 이용해서 보내는 요청
- Spring Boot 가 사용되었습니다.
- composite 을 이용해서 두가지 type 의 notifier 를 호출합니다
