INPUT_FILENAME = 'a_an_example.in.txt'
OUTPUT_FILENAME = INPUT_FILENAME[0] + '_out.txt'
skills = dict() #Dictionaries containing the skills available and their level in tuples
projects = list() #List contains the projects in tuples

#Reading inputs
fr = open(INPUT_FILENAME)
lines = fr.readlines()
fr.close()
line = [int(x) for x in lines[0].split()]
C = line[0]
P = line[1]
i = 1
for c in range(C):
    line = lines[i].split()
    i+=1
    contributor = line[0]
    skills_count = int(line[1])
    for j in range(skills_count):
        line = lines[i].split()
        i+=1
        skill = line[0]
        level = int(line[1])
        if skill in skills:
            skills.get(skill).append((level,contributor))
        else:
            skills[skill] = [(level,contributor)]
for skill in skills.items():
    skill[1].sort()
for p in range(P):
    line = lines[i].split()
    i+=1
    project = line[0]
    days = int(line[1])
    score = int(line[2])
    deadline = int(line[3])
    roles = int(line[4])
    tup = (project,days,score,deadline,list())
    for r in range(roles):
        line = lines[i].split()
        i+=1
        tup[4].append((line[0],int(line[1])))
    projects.append(tup)

#Sorting by score
score_sorted = [(score,deadline,days,roles,project) for (project,days,score,deadline,roles) in projects]
score_sorted.sort(reverse = True)

fw = open(OUTPUT_FILENAME,'w')
fw.write(str(len(projects))+ '\n')
for project in score_sorted:
    fw.write(project[4]+'\n')
    for role in project[3]:
        lst = skills.get(role[0])
        for skill in lst:
            if skill[0]>=role[1]:
                fw.write(skill[1] + ' ')
                break
    fw.write('\n')
fw.close()