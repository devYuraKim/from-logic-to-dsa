# Graph Search Strategy - Playbook

- Unweighted Search: DFS, BFS     
- Weighted Shortest Path: Dijkstra(UCS)

> "해당 문제는 [상태 공간]으로 모델링할 수 있으며, 목표가 [모든 탐색/최단 거리]이므로 [알고리즘]을 선택하겠습니다. 간선의 가중치가 [있음/없음]을 고려하여 [BFS/Dijkstra]로 최적의 해를 구하겠습니다."

| 구분 | DFS                                                | BFS | Dijkstra (UCS) |
| :--- |:---------------------------------------------------| :--- | :--- |
| **자료구조** | Stack / Recursion                                  | Queue | Priority Queue (Min-Heap) |
| **최적성** | 보장 안 함 (경로 존재 확인용)                                 | **무가중치** 최단거리 보장 | **가중치** 최단거리 보장 |
| **공간 복잡도** | $O(H)$ (트리 기준, 높이에 비례)<br/>O(V) (그래프 재귀/스택 기준, 최악) | $O(W)$ (너비에 비례) | $O(V)$ |
| **주요 키워드** | 백트래킹, 사이클, 모든 조합                                   | 최소 이동 횟수, 계층 탐색 | 최소 비용, 가중치 그래프 |

---

## 1. 탐색 알고리즘을 알아야 하는 이유

### DFS (깊이 우선 탐색)
- **핵심 목적**: **모든 가능한 경로**(전수 조사) 탐색 및 경로의 특징 확인.
- **면접 포인트**: 백트래킹(Backtracking)과 결합하여 조합, 순열 등을 생성할 때 필수입니다. 사이클 존재 여부를 파악하거나 연결 요소(Connected Components)를 찾을 때 유리합니다. 재귀(Stack)의 깊이 제한 문제에 대해 논리적으로 방어할 준비가 되어 있어야 합니다.
> “모든 경우를 탐색 / 구조 파악” 
> - 백트래킹 
> - 조합/순열 
> - 트리 구조 탐색
> - 경로 존재 여부 (Path existence)
> 
> “전체 경우를 다 봐야 합니다 → DFS”

### BFS (너비 우선 탐색)     
- **핵심 목적**: 가중치가 없는 그래프에서의 **최단 경로** 찾기.
- **면접 포인트**: "최단 거리", "최소 단계", "가장 가까운 노드" 등의 키워드가 나올 때 가장 먼저 떠올려야 합니다. 레벨 단위(Layer-by-layer)로 탐색하기 때문에 메모리 사용량(Queue) 관리에 대한 질문이 뒤따르기도 합니다.

> "최단 거리 (무가중치)"
> - 최단 이동 횟수
> - 레벨 단위 탐색
> - multi-source 확산
> 
> "최단 경로고 가중치 없음 → BFS"

### UCS / Dijkstra (균일 비용 탐색)
- **핵심 목적**: **가중치가 있는 그래프**에서의 최단 경로 찾기.
- **면접 포인트**: 단순 BFS로 해결할 수 없는 '비용' 개념이 들어간 문제(예: Google Maps의 경로 탐색 최적화)에 필수입니다. 우선순위 큐(Heap)의 시간 복잡도($O(E \log V)$)를 정확히 이해하고 설명할 수 있는지가 중요합니다.

> "가중치 있는 최단 거리"
> - 비용이 다를 때
> - priority queue 사용
> 
> "가중치 있으니까 BFS 말고 Dijkstra"


---

## 2. LeetCode 문제
👉must
⭐frequent

### 1. DFS / 백트래킹

- `78. Subsets`: DFS 구조 이해 핵심
- `46. Permutations`: 상태 공간 트리 이해
- `39. Combination Sum`: pruning 감각
- 👉`200. Number of Islands`: grid DFS 기본
- `543. Diameter of Binary Tree`: 트리 DFS 사고력
- ⭐ `79. Word Search`: 면접 단골, 백트래킹의 정수

### 2. BFS
- 👉`102. Binary Tree Level Order Traversal`: BFS 기본
- `200. Number of Islands`: DFS vs BFS 비교 (보통 공간 복잡도 때문에 DFS 선호 -- Stack depth vs Queue size)
- `994. Rotting Oranges`: multi-sources BFS (중요)
- ⭐`127. Word Ladder`: 면접 단골, bidirectional BFS(양방향 탐색)로 최적화 가능
- 👉⭐`1091. Shortest Path in Binary Matrix`: grid 최단거리

### 3. UCS / Dijkstra
- 👉⭐`743. Network Delay Time`: Dijkstra 기본기
- `1631. Path With Minimum Effort`: 변형된 최단경로
- 👉`787. Cheapest Flights Within K Stops`: 조건 붙은 최단경로

---

## 3. 평가 및 풀이 포인트

### 1. 평가 포인트
- 문제를 보고 **그래프/트리로 추상화**할 수 있는가
- DFS vs BFS 중 **왜 이걸 선택**했는지 설명 가능한가
- 최단거리 → BFS / 가중치 → UCS(Dijkstra) **자동으로 연결**되는가

### 2. 풀이 포인트

문제 풀 때 항상 이 질문을 할 것:

#### 1. 상태 공간은 무엇?
모든 문제는 결국 graph로 모델링 됨
- grid?
- graph?
- tree?

#### 2. 목표는 무엇?
- 전부 탐색 → DFS
- 최단 거리 → BFS
- 최소 비용 → UCS

#### 3. 방문 처리는 어떻게?
- visited?
- memo?
- pruning?

#### 4. 시간 . 공간 복잡도?
- **BFS/DFS**: 일반적인 탐색 시 $O(V + E)$, 조합/순열(백트래킹) 시에는 $O(2^n)$ 또는 $O(n!)$
- **UCS/Dijkstra**: $O(E \log V)$ 또는 $O(E + V \log V)$ (사용하는 힙 구조에 따라 다름)

---

## 4. 빠른 선택 규칙 (Interview Trigger)

- "모든 경우 / 조합 / 탐색" → DFS
- "최단 거리 (무가중치)" → BFS
- "최소 비용 / 가중치" → Dijkstra

판단 순서:

1. **그래프인가?**     
    (Tree, Matrix, Node/Edge 모두 포함)
2. **목표가 무엇인가?**
   - 경로의 특징/존재 여부/모든 조합: $\rightarrow$ DFS (재귀 깊이가 너무 깊다면 Stack 사용 고려)
   - 최단 경로(Shortest Path): $\rightarrow$ 다음 단계로
3. **간선(Edge)에 가중치가 있는가?**
   - NO (가중치 동일): $\rightarrow$ BFS
     > “BFS는 queue를 사용하여 level 단위로 탐색하기 때문에,
       어떤 노드를 처음 방문했을 때의 경로가 가장 짧은 경로입니다.”
     > 
     > "DFS는 경로를 전부 탐색해야 최단 경로를 보장할 수 있으므로,
     최단 경로 문제에는 비효율적입니다." 
   - YES (가중치 다름): $\rightarrow$ Dijkstra (UCS)
     > “BFS는 모든 간선 비용이 동일할 때만 최단 경로를 보장합니다.
     비용이 다르면 ‘먼저 도착한 경로’가 최단이 아닐 수 있기 때문에,
     누적 비용 기준으로 탐색하는 Dijkstra를 사용합니다.”
   - (Advanced) 목표 지점의 방향(Heuristic)을 아는가?: $\rightarrow$ A*

[**Pro Tip: 면접 방어용 체크리스트**]     
- **Cycle이 존재하는가?**: `visited` 처리 필수 (무한 루프 방지)
- **가중치가 음수인가?**: Dijkstra 사용 불가 $\rightarrow$ **Bellman-Ford** 고려 (면접 단골 압박 질문)
- **공간 복잡도 제약**: BFS는 큐에 노드가 많이 쌓일 수 있음 ($O(W)$, $W$는 그래프의 최대 너비), DFS 고려