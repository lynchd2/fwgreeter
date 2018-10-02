/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Dylan.Lynch
 * Created: Oct 2, 2018
 */

CREATE DATABASE IF NOT EXISTS fwgreeter;
CREATE USER 'fwgreeter'@'localhost' IDENTIFIED BY 'fwgreeter';
GRANT ALL PRIVILEGES ON *.* TO 'fwgreeter'@'localhost'
WITH GRANT OPTION;