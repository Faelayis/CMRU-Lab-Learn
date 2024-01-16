p = ["Python", "C", "PHP", "ASP"]

p.append("Java")
print(p)

count = p.count("Python")
print(count)

p.remove("Python")
print(p)

p.sort()
print(p)

p.reverse()
print(p)

p.clear()
print(p)

p.insert(0, "TypeScript")
print(p)

# output  :
# append : ['Python', 'C', 'PHP', 'ASP', 'Java']
# count  : 1
# remove : ['C', 'PHP', 'ASP', 'Java']
# sort   : ['ASP', 'C', 'Java', 'PHP']
# reverse: ['PHP', 'Java', 'C', 'ASP']
# clear  : []
# insert : ['TypeScript']
