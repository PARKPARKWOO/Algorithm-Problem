words = input().upper() # 모든 단어를 대문자로
word = list(set(words)) # 중복 없애기
word_list = []
# 중복 없앤 단어들 확인하며
for i in word:
    counts = words.count(i) # 입력 받은 단어마다 개수 저장
    word_list.append(counts) # 개수 리스트에 삽입
# 개수가같은 단어가 중복된다면 ? 출력
if word_list.count(max(word_list)) > 1:
    print("?")
else:
    print(word[(word_list.index(max(word_list)))])
    # 제일 많은 개수 인덱스값 = 중복 없앤 인덱스값 해서 제일 많이 입력된 알파벳 찾기
