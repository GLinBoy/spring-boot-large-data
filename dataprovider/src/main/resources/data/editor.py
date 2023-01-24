import os


main_file_name = 'news.json'
mini_file_name = 'mini_news.json'
final_prefix = 'final_'
mini_file_lines = 100

print('---> Main file lines count: %d' %
      sum(1 for i in open(main_file_name, 'rb')))


def generate_mini_file():
    if os.path.exists(mini_file_name):
        os.remove(mini_file_name)
    with open(main_file_name) as myfile:
        head = [next(myfile) for x in range(mini_file_lines)]

    with open(mini_file_name, 'w') as modified:
        for line in head:
            modified.write(line)


def convert_to_json(file_name):
    file_path = f'{final_prefix}{file_name}'
    if os.path.exists(file_path):
        os.remove(file_path)
    with open(file_name) as f:
        lines = f.read().splitlines()
        with open(file_path, 'w') as new_file:
            new_file.write('[\n')
            lines_len = len(lines)-1
            for index, line in enumerate(lines):
                if index == lines_len:
                    new_file.write('%s\n' % line)
                else:
                    new_file.write('%s,\n' % line)
            new_file.write(']')


if __name__ == '__main__':
    generate_mini_file()
    convert_to_json(main_file_name)
