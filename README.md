RSA Project Cryptography CS352

The Project - and the Rules of the Game


Cryptography CSCI 352/780 
Spring, 2014, Queens College
Prof. Kent D. Boklan

You are tasked with breaking a cryptographic protocol; the Fate of Humanity may depend upon your efforts. If you fail, Chaos may reign. You will be working with a team of experts. 

1. Someone (no doubt evil) has sent a short message using the RSA mechanism. The public  
    information is (e,n) where e=31 and n is equal to
495960937377360604920383605744987602701101399399359259262820733407167 .  
    English plaintext was converted to a numerical value by taking the place of each letter 
    in the alphabet (1-26). (So BOY becomes 21525.) Note that the inverse operation is not   
    uniquely defined. Your operatives have intercepted the encrypted message
19705178523446373241426321455642097240677633038639787310457022491789 .
    And now it’s up to you. Recover the critical plaintext. 

Guidelines:

It is very likely that you (and your team) will need extensive computing power – and time.

All code that is used by your group must be written by persons in your group with the exceptions discussed on this page.

You may not download or otherwise employ a program from an outside source and use it. Some allowance will be made for linear algebra packages for the RSA and Diffie-Hellman groups. Large integer packages for the RSA and Diffie-Hellman groups are allowed. Library function calls (say to find a gcd or to find a factor) are not allowed. To the RSA group: you cannot use a factoring program unless you have written it yourselves.

It will be assumed that everyone in your group understands the “attacks” and approaches you are undertaking. Do not use Mathematics that you do not understand. Each member of your group is responsible for the actions of the others. If you need help or advice, ask me. If you have questions, ask me.  

I will provide some hints and guidance as to what may be effective approaches.

Each group will hand in one detailed paper describing their efforts. This is the most important aspect of the project and the one that will weigh most heavily upon your grade. The report should present issues and difficulties as well as victories. Hand in the well-commented source code for your work. I may also ask for your executable files. An evaluation will be based upon what you show you have done, not what you have done. High grades may be obtained without successfully “breaking” the system. Your score will be strongly influenced by the content, clarity and insights of the report and the quality of your approaches and attempts. 

Consider multiple approaches and document all of your considerations.  An individual’s project grade will be proportional to both the (quality of the) report and to their contribution to the group work. Everyone must submit to me a list of the members in their group and a (private) opinion as to each member’s contribution to the code breaking effort – all in addition to signing a pledge that all of the rules adumbrated on this page was followed. I will judge the merits of these impressions and assign grades accordingly. Each group will give a 20-25 minute presentation of their work on Tuesday, April 29, 2014, the day the project reports are due. The presentations will be graded by the audience for the talks.    
