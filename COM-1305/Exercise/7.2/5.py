import random

choices = {"p": "กระดาษ", "s": "กรรไกร", "h": "ค้อน"}
player_score = 0
computer_score = 0

print("(P) กระดาษ, (S) กรรไกร, (H) ค้อน")

while player_score < 3 and computer_score < 3:
    computer_choice = random.choice(list(choices.keys()))
    player_input = input("ป้อนตัวอักษร : ").lower()

    print("คอมพิวเตอร์สุ่มได้ ", choices[computer_choice])
    print()

    if choices[computer_choice] == choices[player_input]:
        print("เสมอ")
    elif choices[computer_choice] == "p" and choices[player_input] == "s":
        print("ผู้เล่นชนะ")
        player_score += 1
    elif choices[computer_choice] == "h" and choices[player_input] == "p":
        print("ผู้เล่นชนะ")
        player_score += 1
    elif choices[computer_choice] == "s" and choices[player_input] == "h":
        print("ผู้เล่นชนะ")
        player_score += 1
    else:
        print("คอมพิวเตอร์ชนะ")
        computer_score += 1
    print()

if player_score == 3:
    print(f"ผู้เล่นชนะเกม! {player_score}:{computer_score}")
else:
    print(f"คอมพิวเตอร์ชนะเกม! {computer_score}:{player_score}")
print()
