package level1.cleanWallpaper;

import java.util.ArrayList;
import java.util.List;

/**
 * 작성일 : 2023/09/10
 * 문제 설명 : 코딩테스트를 준비하는 머쓱이는 프로그래머스에서 문제를 풀고 나중에 다시 코드를 보면서 공부하려고 작성한 코드를 컴퓨터 바탕화면에 아무 위치에나 저장해 둡니다.
 * 저장한 코드가 많아지면서 머쓱이는 본인의 컴퓨터 바탕화면이 너무 지저분하다고 생각했습니다.
 * 프로그래머스에서 작성했던 코드는 그 문제에 가서 다시 볼 수 있기 때문에 저장해 둔 파일들을 전부 삭제하기로 했습니다.
 * 컴퓨터 바탕화면은 각 칸이 정사각형인 격자판입니다. 이때 컴퓨터 바탕화면의 상태를 나타낸 문자열 배열 wallpaper가 주어집니다.
 * 파일들은 바탕화면의 격자칸에 위치하고 바탕화면의 격자점들은 바탕화면의 가장 왼쪽 위를 (0, 0)으로 시작해 (세로 좌표, 가로 좌표)로 표현합니다.
 * 빈칸은 ".", 파일이 있는 칸은 "#"의 값을 가집니다. 드래그를 하면 파일들을 선택할 수 있고, 선택된 파일들을 삭제할 수 있습니다.
 * 머쓱이는 최소한의 이동거리를 갖는 한 번의 드래그로 모든 파일을 선택해서 한 번에 지우려고 하며 드래그로 파일들을 선택하는 방법은 다음과 같습니다.
 *  - 드래그는 바탕화면의 격자점 S(lux, luy)를 마우스 왼쪽 버튼으로 클릭한 상태로 격자점 E(rdx, rdy)로 이동한 뒤 마우스 왼쪽 버튼을 떼는 행동입니다.
 * 이때, "점 S에서 점 E로 드래그한다"고 표현하고 점 S와 점 E를 각각 드래그의 시작점, 끝점이라고 표현합니다.
 *  - 점 S(lux, luy)에서 점 E(rdx, rdy)로 드래그를 할 때, "드래그 한 거리"는 |rdx - lux| + |rdy - luy|로 정의합니다.
 *  - 점 S에서 점 E로 드래그를 하면 바탕화면에서 두 격자점을 각각 왼쪽 위, 오른쪽 아래로 하는 직사각형 내부에 있는 모든 파일이 선택됩니다.
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/161990
 */

public class Solution {
    public int[] solution(String[] wallpaper) {

        int yLength = wallpaper.length;
        int xLength = wallpaper[0].length();

        List<Integer> xList = new ArrayList<>();
        List<Integer> yList = new ArrayList<>();

        for(int y = 0 ; y < yLength ; y++) {
            char[] charArr = wallpaper[y].toCharArray();
            for (int x = 0; x < xLength; x++) {
                if (charArr[x] == '#') {
                    xList.add(x);
                    yList.add(y);
                }
            }
        }

        int minX = Integer.MAX_VALUE;
        int maxX = -1;
        int minY = Integer.MAX_VALUE;
        int maxY = -1;

        // 문제에서 세로를 x축으로, 가로를 y축으로 결과를 만듬
        for(Integer xNum : yList) {
            minX = minX > xNum ? xNum : minX;
            maxX = maxX < xNum ? xNum : maxX;
        }

        for(Integer yNum : xList) {
            minY = minY > yNum ? yNum : minY;
            maxY = maxY < yNum ? yNum : maxY;
        }

        // 문제에서 끝점을 구하는 방식으로 인해 max는 + 1
        return new int[] {minX,
                          minY,
                          maxX + 1,
                          maxY + 1};
    }
}