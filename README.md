# java-racingcar-precourse

# 자동차 경주

## 목적
- 여러 역할을 수행하는 큰 함수를 단일 책임 함수로 분리
- JUnit5/AssertJ로 동작 검증
- 1주차 공통 피드백 및 우테코 자바 스타일 가이드 준수

## 입출력 형식
- 입력 1: `경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)`
  - 예: `pobi,woni,jun`
- 입력 2: `시도할 횟수는 몇 회인가요?`
  - 예: `5`
- 출력
  - 라운드별: `이름 : ----`
  - 최종: `최종 우승자 : pobi, jun`

## 규칙
- 이름: 쉼표 구분, **1~5자**, 공백(whitespace) 포함 금지, 빈 토큰 금지
- 시도 횟수: **양의 정수**
- 전진 규칙: 0~9 난수 중 **4 이상이면 전진**
- 잘못된 입력: `IllegalArgumentException` 발생, 메인에서 catch하지 않음(전파)

## 사용 라이브러리
- `camp.nextstep.edu.missionutils.Randoms#pickNumberInRange(0, 9)`
- `camp.nextstep.edu.missionutils.Console#readLine()`

## 구현 구조
- `Application` : 콘솔 I/O만 담당
- `InputValidator` : 입력 파싱/검증
- `RacingGame` : 라운드 진행, 우승자 계산
- `Car` : 이름/위치, 전진
- `NumberPicker`/`RandomNumberPicker` : 난수 전략(테스트 용이성)
- `Printer` : 모든 출력 포맷

## 기능 목록 (체크는 구현/검증 후)
- [ ] 입력: 자동차 이름 CSV 읽기
- [ ] 검증(이름): 1~5자, 공백/빈 토큰 금지 → 위반 시 `IllegalArgumentException`
- [ ] 입력: 시도 횟수 읽기
- [ ] 검증(횟수): 숫자만, 양의 정수 → 위반 시 `IllegalArgumentException`
- [ ] 라운드 진행: 매 시도마다 모든 차에 대해 0~9 난수, **4 이상 전진**
- [ ] 출력(라운드): `이름 : ----` 포맷
- [ ] 우승자 계산/출력: 최종 최대 거리 동점 허용, `최종 우승자 : A, B`
- [ ] 예외 정책: 메인에서 예외 **전파**
- [ ] 스타일: 들여쓰기 depth ≤ 2, 3항 연산자 금지, 단일 책임 함수

## 실행/테스트
```bash
./gradlew clean test
