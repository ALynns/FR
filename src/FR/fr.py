import os
import sys
KN_PICTURE_PATH = sys.argv[1]
UN_PICTURE_PATH = sys.argv[2]
RESULTFILE_PATH = "G:/Eclipse/facerecognitiongui/src/FR/result/result.txt"    # This is the path of result file
FILE = open(RESULTFILE_PATH, "w")
result = os.popen('python G:/Eclipse/facerecognitiongui/src/FR/recg.py '+KN_PICTURE_PATH+' '+UN_PICTURE_PATH)
res = result.read()
for line in res.splitlines():
    if "WARNING" in line:
        pass
    else:
        #print(line[line.index(',')+1:])
        wline = line[line.index(',') + 1:]
        print(wline)
        FILE.write(wline+'\n')
FILE.close()