package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

final class RandomNumberPicker implements NumberPicker {
    @Override
    public int pick0to9() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
