for y in range (0, 5):
  
  strs = str('')
  for x in range(0, 3):
    
    stringz = input()
    
    #idk how to use regex in python
    stringz = stringz.replace('a', 'F@ls!')
    stringz = stringz.replace('v', 'or')
    stringz = stringz.replace('~', 'not ')
    stringz = stringz.replace('^', 'anz')
    stringz = stringz.replace('c', 'Tru!')
    stringz = stringz.replace('b', 'F@ls!')
    stringz = stringz.replace('d', 'F@ls!')
    stringz = stringz.replace('e', 'F@ls!')
    stringz = stringz.replace('f', 'F@ls!')
    stringz = stringz.replace('g', 'F@ls!')
    stringz = stringz.replace('h', 'F@ls!')
    stringz = stringz.replace('i', 'F@ls!')
    stringz = stringz.replace('j', 'F@ls!')
    stringz = stringz.replace('@', 'a')
    stringz = stringz.replace('!', 'e')
    stringz = stringz.replace('z', 'd')
    
    #print(stringz)
    if(('and' in stringz or 'or' in stringz) and (eval(stringz)) and 'False or False' not in stringz and 'not True or False' not in stringz and 'False or not True' not in stringz and 'not True or not True' not in stringz):
      strs += "Y"
    
    else:
      strs += "N"
    
  print(strs)