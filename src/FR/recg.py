#!/usr/bin/python
# -*- coding=UTF-8 -*-
import re
import sys
import face_recognition
from face_recognition.face_recognition_cli import main
if __name__ == '__main__':
    sys.argv[0] = re.sub(r'(-script\.pyw?|\.exe)?$', '', sys.argv[0])
    sys.exit(main())