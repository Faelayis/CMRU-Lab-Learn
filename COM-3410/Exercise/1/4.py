list = ['abc', 'xyz', 'aba', '1221', 'กนก','dawdad']
result = []

for x in list:
  if len(x) >= 2 and x[0] == x[-1]:
    result.append(x)

print(result)
print("Expected Result :" , len(result))